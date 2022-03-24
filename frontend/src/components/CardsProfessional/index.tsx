import { Link } from 'react-router-dom';
import Raissa from '../../assets/raissa.jpeg';
import editImg from '../../assets/edit.svg';
import removeImg from '../../assets/remove.svg';
import whatsappImg from '../../assets/whatsapp.svg';

import './style.css';

export function CardsProfessional() {
    return (
        <div id="content">
            <div id="profissional-content">
                <div className="profissional-datas">
                    <footer>
                        <img src={Raissa} alt="Profissional" />
                        <div>
                            <h2>Raissa Vieira</h2>
                            <h3>Engenheira</h3>
                        </div>
                    </footer>
                    <div className="actions">
                        <Link to="/professional/edit">
                            <img src={editImg} alt="Editar" />
                        </Link>
                        <img src={removeImg} alt="Remover" />
                    </div>
                </div>
                <div className="bio">
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet nisi beatae quam modi necessitatibus numquam temporibus labore,
                        similique veritatis inventore esse consectetur dicta, ipsam corrupti quae accusantium adipisci alias ipsum?
                    </p>
                </div>
            </div>
            <div id="profissional-contact">
                <button>
                    <img src={whatsappImg} alt="Whatsapp"/>
                    Entrar em contato
                </button>
            </div>
        </div>
    )
}