import React from 'react';
import AuthorBooks from '../components/AuthorBooks';
import axios from  '../config/axios'
import { useEffect, useState } from 'react'
function BooksByAuthor() {

    const[authorBooks, setAuthorBooks]= useState([])
    const[searchValue, setSearchValue] = useState('');

    const getAuthorBooks = async (author) =>{
        try{
            const res= await axios.get(`/autores/${author}/libros`)
            setAuthorBooks(res.data)
        }catch (e){
            console.log(e)
        }
    }

  return (
    <div>
      <AuthorBooks authors={authorBooks} getAuthorBooks={getAuthorBooks} searchValue={searchValue}/>
    </div>
  );
}

export default BooksByAuthor;
