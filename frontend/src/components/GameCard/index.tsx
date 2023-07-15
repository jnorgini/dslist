import './styles.css';
import { GameDTO } from '../../models/game';

type Props = {
    game: GameDTO;
}

export default function GameCard({ game }: Props) {

    return (
        <div className="card card-game-listing">
            <div className="game-card-listing-left-container">
                <img src={game.imgUrl} alt={game.title} />
            </div>
            <div className="game-card-listing-right-container">
                <h3>{game.title}</h3>
                <p>{game.shortDescription}</p>
                <h4>{game.year}</h4>
            </div>
        </div>
    );
}
