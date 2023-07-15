import './styles.css';

type Props = {
    text: string;
}

export default function BigButton({ text }: Props) {

    return (
        <div className="big-button">
            {text}
        </div>
    );
}