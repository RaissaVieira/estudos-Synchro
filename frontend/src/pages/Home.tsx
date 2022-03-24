import { useNavigate } from 'react-router-dom';
import { CardsProfessional } from '../components/CardsProfessional';
import { Header } from '../components/Header';
import '../styles/home.css';

export function Home() {

    const navigate = useNavigate();

    async function handleCreateProfissional() {
        navigate("/professional/new");
    }

    return (
        <div id="home">
            <Header isHome>
                <h1>
                    Estes são os profissionais disponíveis
                </h1>
            </Header>

            <main className="list-profissional">
                <button className="button-create-profissional" onClick={handleCreateProfissional}>Cadastrar profissional</button>

                {/* <p className="no-profissional">
                    Nenhum profissional cadastrado até
                    o momento.
                </p> */}

                <CardsProfessional/>
                <CardsProfessional/>
            </main>
        </div>
    );
}