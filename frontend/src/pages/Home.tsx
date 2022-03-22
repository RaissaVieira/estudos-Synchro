import { CardsProfessional } from '../components/CardsProfessional';
import '../styles/home.css';

export function Home() {
    return (
        <div id="home">
            <header>
                Estes são os profissionais disponíveis
            </header>
            <button className="create-profissional">Cadastrar profissional</button>
            {/* <div className="no-profissional">
                Nenhum profissional cadastrado até
                <br/> o momento.
            </div> */}

            <main className="list-profissional">
                <CardsProfessional/>
            </main>
        </div>
    );
}