import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import Book from '../components/Book'
import { bookcontext } from '../context/bookcontext'

function BookList(){

    const[bookList, setBookList]= useState([])
    const [searchValue, setSearchValue] = useState('');

    const getOneBook = async (book) =>{
        try{
            const res = await axios.get(`/libros/${book}`)
            setBookList(res.data)
        }catch (e){
            console.log(e)
        }
    }

    const getBooks = async () =>{
        try{
            const res = await axios.get("/libros")
            console.log(res.data)
            setBookList(res.data)
        }catch (e){
            console.log(e)
        }
    }

    const handleDeleteBook = async (bookId) => {
        try {
          await axios.delete(`/libros/${bookId}`);
          getBooks(); // Actualiza la lista después de la eliminación
          alert('¡Acabas de borrar un libro!');
        } catch (e) {
          console.log(e);
        }
    }

    
    return(
        <bookcontext.Provider>
            <h1 style={{
                marginBottom: '30px'
            }} >Libros</h1>
            <Book books={Array.isArray(bookList)? bookList: [bookList]} getOneBook={getOneBook} getBooks={getBooks} onDeleteBook={handleDeleteBook} searchValue={searchValue}/>
        </bookcontext.Provider>
    )
}

export default BookList