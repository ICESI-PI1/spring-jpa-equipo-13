import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import Author from '../components/Author'
import { bookcontext } from '../context/bookcontext'

function AuthorList(){

    const[authorList, setAuthorList]= useState([])
    const [searchValue, setSearchValue] = useState('');

    const getOneAuthor = async (author) =>{
        try{
            const res = await axios.get(`/autores/${author}`)
            setAuthorList(res.data)
        }catch (e){
            console.log(e)
        }
    }

    const getAuthors = async () =>{
        try{
            const res = await axios.get("/autores")
            setAuthorList(res.data)
        }catch (e){
            console.log(e)
        }
    }

    const handleDeleteAuthor = async (authorId) => {
        try {
          await axios.delete(`/autores/${authorId}`);
          alert('¡Acabas de borrar un Autor!');
          getAuthors(); // Actualiza la lista después de la eliminación
        } catch (e) {
          console.log(e);
        }
    }
    
    return(
        <bookcontext.Provider>
            <h1 style={{
                marginBottom: '30px'
            }} >Autores</h1>
            <Author authors={Array.isArray(authorList) ? authorList : [authorList]} getOneAuthor={getOneAuthor} getAuthors={getAuthors} onDeleteAuthor={handleDeleteAuthor} searchValue={searchValue}/>
        </bookcontext.Provider>
    )
}

export default AuthorList
