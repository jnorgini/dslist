import './styles.css';
import * as gameService from '../../../../services/game-service';
import { useParams } from 'react-router-dom';
import GameCardFull from '../../../../components/GameCardFull';
import { useEffect, useState } from 'react';
import { GameDTO } from '../../../../models/game';

export default function Game() {

    const params = useParams();

    const [game, setGame] = useState<GameDTO>();

    useEffect(() => {
        gameService.findByIdRequest(Number(params.gameId))
            .then(response => {
                setGame(response.data);
            })
    }, [params.gameId]);

    return (
        <main>
            <section className="game-section">
                <div className="container">
                    {game && <GameCardFull game={game} />}
                </div>
            </section>
        </main>
    );
}
