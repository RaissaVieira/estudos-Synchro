import Diego from '../../assets/Diego.png';
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
                        <img src={Diego} alt="Profissional" />
                        <div>
                            <h2>Raissa Vieira</h2>
                            <h3>Engenheira</h3>
                        </div>
                    </footer>
                    <div className="actions">
                        <img src={editImg} alt="Editar" />
                        <img src={removeImg} alt="Remover" />
                    </div>
                </div>
                <div>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet nisi beatae quam modi necessitatibus numquam temporibus labore,
                    similique veritatis inventore esse consectetur dicta, ipsam corrupti quae accusantium adipisci alias ipsum?
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