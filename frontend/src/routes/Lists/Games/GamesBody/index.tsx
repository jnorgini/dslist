import './styles.css';
import * as gameService from '../../../../services/game-service';
import * as listService from '../../../../services/list-service';
import { useEffect, useState } from "react";
import { DragDropContext, Draggable, Droppable, DropResult } from "react-beautiful-dnd";
import GameCardDraggable from "../../../../components/GameCardDraggable";
import { GameDTO } from '../../../../models/game';
import { useParams } from 'react-router-dom';
import { ListDTO } from '../../../../models/list';
import { Link } from 'react-router-dom';

export default function GamesBody() {

    const params = useParams();

    const [list, setList] = useState<ListDTO>();
    const [games, setGames] = useState<GameDTO[]>([]);

    useEffect(() => {
        listService.findByIdRequest(Number(params.listId))
            .then(responseList => {
                gameService.findByListRequest(Number(params.listId))
                    .then(responseGames => {
                        setList(responseList.data);
                        setGames(responseGames.data);
                    })
            })
    }, [params.listId]);

    const handleDragEnd = (result: DropResult) => {

        const { source, destination } = result;

        if (!destination) {
            return;
        }

        listService.move(Number(params.listId), source.index, destination.index)
            .then(() => {
                const newItems = Array.from(games);
                const [obj] = newItems.splice(source.index, 1); // remove obj at source position from array
                newItems.splice(destination.index, 0, obj); // add obj at destination position
                setGames(newItems);
            });
    }

    return (
        <main>
            <section className="games-section">
                <div className="container">
                    {list &&
                        <>
                            <h2>{list.name}</h2>
                            <DragDropContext onDragEnd={handleDragEnd}>
                                <Droppable droppableId="games">
                                    {(provided) => (
                                        <div className="game-listing-container" {...provided.droppableProps} ref={provided.innerRef}>
                                            {games.map((game, index) => (
                                                <Link key={game.id} to={`/lists/${list.id}/games/${game.id}`}>
                                                    <Draggable draggableId={String(game.id)} index={index}>
                                                        {(provided, snapshot) => (
                                                            <GameCardDraggable provided={provided} snapshot={snapshot} game={game} />
                                                        )}
                                                    </Draggable>
                                                </Link>
                                            )
                                            )}
                                            {provided.placeholder}
                                        </div>
                                    )}
                                </Droppable>
                            </DragDropContext>
                        </>
                    }
                </div >
            </section>
        </main >
    );
}
