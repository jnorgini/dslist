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
                            <p>Organize sua coleção de games de um jeito prático de divertido. Na verdade
                                você vai aprender a criar este aplicativo e elevar seus conhecimentos
                                para o próximo nível :)
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
