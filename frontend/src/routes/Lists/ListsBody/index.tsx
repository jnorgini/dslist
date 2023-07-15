import './styles.css';
import * as listService from '../../../services/list-service';
import { useEffect, useState } from 'react';
import { ListDTO } from '../../../models/list';
import { Link } from 'react-router-dom';

export default function ListsBody() {

    const [list, setList] = useState<ListDTO[]>([]);

    useEffect(() => {
        listService.findAllRequest()
            .then(response => {
                setList(response.data);
            })
    }, []);

    return (
        <main>
            <section className="lists-section">
                <div className="container">
                    <div className="card card-collections">
                        <h2>Minhas coleções</h2>
                        <ul>
                            {list.map(item => (
                                <Link key={item.id} to={`/lists/${item.id}/games`}>
                                    <li>{item.name}</li>
                                </Link>
                            ))}
                        </ul>
                    </div>
                </div>
            </section>
        </main>
    );
}
