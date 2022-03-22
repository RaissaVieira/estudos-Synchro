import InputMask from 'react-input-mask';

import backIcon from '../assets/back.svg';
import fileIcon from '../assets/file.svg';
import atencaoIcon from '../assets/atencao.svg';

import '../styles/createProfessional.css';

export function CreateProfessional() {
    return (
        <div id="create-professional">
            <header>
                <img src={backIcon} alt="Voltar"/>
                <div>
                    <h1>
                        Que incrível que você quer ajudar
                    </h1>
                    <h2>
                        O primeiro passo, é preencher esse
                        formulário de inscrição.
                    </h2>
                </div>
            </header>
            <div className="container-form">
                <h1>Dados Pessoais</h1>
                <div className="separator"></div>
                <form>
                    <label htmlFor="Name">Nome Completo</label>
                    <input type="text" id="Name"/>
                    <label htmlFor="Cpf">CPF</label>
                    <InputMask mask="999.999.999-99" id="Cpf"/>
                    <label htmlFor="Birthday">Data de nascimento</label>
                    <InputMask mask="99/99/9999" id="Birthday"/>
                    <label htmlFor="Whats">Whatsapp</label>
                    <InputMask mask="(99)99999-9999" id="Whats"/>
                    <label htmlFor="Photo" id="file">
                        <p>Link da sua foto</p> 
                        <div>
                            <img src={fileIcon}/>
                        </div>
                    </label>
                    <input type="file" id="Photo"/>
                    <label htmlFor="Profession">Profissão</label>
                    <input type="text" id="Profession"/>
                    <label htmlFor="Bio">Biografia</label>
                    <textarea id="Bio"></textarea>
                    <div id="submit">
                        <div id="content">
                            <div>
                                <img src={atencaoIcon} alt="Atenção"/>
                                <p>Importante! <br/>
                                Preencha todos os dados</p>
                            </div>

                            <button type="submit">Salvar cadastro</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}