import { DraggableProvided, DraggableStateSnapshot } from "react-beautiful-dnd";
import { GameDTO } from "../../models/game";
import GameCard from "../GameCard";

type Props = {
    provided: DraggableProvided;
    snapshot: DraggableStateSnapshot;
    game: GameDTO;
}

// eslint-disable-next-line @typescript-eslint/no-explicit-any
function getItemStyle(isDragging: boolean, draggableStyle: any) {
    return {
        ...draggableStyle,
        border: isDragging ? "2px dotted var(--color-blue-medium)" : "none"
    }
}

export default function CustomDraggableItem({ provided, snapshot, game }: Props) {
    return (
        <div
            ref={provided.innerRef}
            {...provided.draggableProps}
            {...provided.dragHandleProps}
            style={getItemStyle(snapshot.isDragging, provided.draggableProps.style)}
        >
            <GameCard game={game} />
        </div>
    )
}
