import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { CardsProfessional, Professional } from '../components/CardsProfessional';
import { Header } from '../components/Header';
import api from '../services/api';
import '../styles/home.css';

export function Home() {
    const [professionals, setProfessionals] = useState([]);

    const navigate = useNavigate();

    async function handleCreateProfissional() {
        navigate("/professional/new");
    }

    useEffect(() => {
        api.get('professionals').then((response) => {
            setProfessionals(response.data);
        }).catch(() => {
            alert("Erro ao listar profissionais.")
        });
    }, [])

    async function handleDeleteProfessional(cpf:String) {
        const result = window.confirm("Deseja remover o profissional?");

        if(result){
            await api.delete(`professionals/${cpf}`);

            await api.get('professionals').then((response) => {
                setProfessionals(response.data);
            }).catch(() => {
                alert("Erro ao listar profissionais.")
            });
        }

        return;
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

                {professionals.length === 0 ? 
                    <p className="no-profissional">
                        Nenhum profissional cadastrado até
                        o momento.
                    </p> :

                    <>
                        {professionals.map((professional : Professional) => {
                            return <CardsProfessional professional={professional} handleDeleteProfessional={handleDeleteProfessional} />
                        })}
                    </>
                    
                }

            </main>
        </div>
    );
}