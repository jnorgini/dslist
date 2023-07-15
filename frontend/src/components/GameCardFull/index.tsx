import './styles.css';
import { GameDTO } from '../../models/game';
import Stars from '../Stars';

type Props = {
    game: GameDTO;
}

export default function GameCardFull({ game }: Props) {

    return (
        <div className="card game-card-full-container">
            <div className="game-card-full-upper">
                <div className="game-card-full-image-container">
                    <img src={game.imgUrl} alt={game.title} />
                </div>
                <div className="game-card-full-info-container">
                    <div className="game-card-full-info-title">
                        <p>{game.year}</p>
                        <h2>{game.title}</h2>
                    </div>
                    <div className="game-card-full-info-attributes">
                        <p>Genre: <span>{game.genre}</span></p>
                        <p>Platforms: <span>{game.platforms}</span></p>
                    </div>
                    <Stars score={game.score} />
                </div>
            </div>
            <div className="game-card-full-bottom">
                <p>{game.longDescription}</p>
            </div>
        </div>
    );
}
