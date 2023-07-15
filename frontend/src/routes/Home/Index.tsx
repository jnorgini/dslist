import './styles.css';
import WelcomeImg from '../../assets/welcome.svg';
import { Link } from "react-router-dom";
import BigButton from "../../components/BigButton";

export default function Home() {

    return (
        <main className="home-main">
            <section className="welcome-section">
                <div className="container welcome-section-container">
                    <div className="welcome-image-container">
                        <img src={WelcomeImg} alt="Welcome" />
                    </div>
                    <div className="welcome-content-container">
                        <div>
                            <h1>DSList PRO</h1>
                            <h2>Suas coleções do jeito certo</h2>
                            <p>O aplicativo definitivo para organizar suas coleções de games de forma prática e divertida! Se você é um entusiasta dos jogos e deseja elevar seus conhecimentos a um nível superior, este é o lugar certo para você.
                            </p>
                        </div>
                        <Link to="/lists">
                            <BigButton text="Iniciar" />
                        </Link>
                    </div>
                </div>
            </section>
        </main>
    );
}
