import { Link } from 'react-router-dom';
import './styles.css';

export default function Header() {

    return (
        <header>
            <div>
                <Link to="/">
                    <h1 className="header-title">DSList</h1>
                </Link>
            </div>
        </header>
    );
}
