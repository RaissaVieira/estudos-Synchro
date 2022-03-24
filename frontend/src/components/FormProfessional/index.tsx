import InputMask from 'react-input-mask';

import fileIcon from '../../assets/file.svg';
import atencaoIcon from '../../assets/atencao.svg';

import './style.css';
import { Button } from '../Button';

export function FormProfessional() {
    return (
        <div className="container-form">
            <h1>Dados Pessoais</h1>
            <div className="separator"></div>
            <form>
                <label htmlFor="Name">Nome Completo</label>
                <input type="text" id="Name" />
                <label htmlFor="Cpf">CPF</label>
                <InputMask mask="999.999.999-99" id="Cpf" />
                <label htmlFor="Birthday">Data de nascimento</label>
                <InputMask mask="99/99/9999" id="Birthday" />
                <label htmlFor="Whats">Whatsapp</label>
                <InputMask mask="(99)99999-9999" id="Whats" />
                <label htmlFor="Photo" id="file">
                    <p>Link da sua foto</p>
                    <div>
                        <img src={fileIcon} />
                    </div>
                </label>
                <input type="file" id="Photo" />
                <label htmlFor="Profession">Profissão</label>
                <input type="text" id="Profession" />
                <label htmlFor="Bio">Biografia</label>
                <textarea id="Bio"></textarea>
                <div id="submit">
                    <div id="content-submit">
                        <div>
                            <img src={atencaoIcon} alt="Atenção" />
                            <p>Importante! <br />
                                Preencha todos os dados</p>
                        </div>

                        <Button type="submit"/>
                    </div>
                </div>
            </form>
        </div>
    )
}