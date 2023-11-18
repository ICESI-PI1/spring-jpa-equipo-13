import React from 'react'
import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import AuthorForm from '../components/AuthorForm'
import { bookcontext } from '../context/bookcontext'
import BookFormEdit from '../components/BookFormEdit'
import { Link , useParams } from 'react-router-dom';


const EditBook = () => {

  
    let {idBook} = useParams();

    const[bookEdit, setBookEdit]= useState({id:"", title:"", publicationDate:"", authorId: ""})

    useEffect(() => {
      getBook();
    }, []);
  

    const getBook = async () => {
      try {
          const res = await axios.get(`/libros/${idBook}`)
          if(res.status == 200){
              //console.log("YESSS")
              setBookEdit(res.data)
          }
      } catch (e) {
          console.log(e);
      }
  }

    const addBook = async (book) => {
      try {
        // Comprueba si el libro ya tiene un ID asignado
        /*
        if (bookEdit.id) {
          // Realiza una solicitud PUT para actualizar el libro
          const res = await axios.put(`/libros/${bookEdit.id}`, book);
          if (res.status === 200) {
            setBookEdit(res.data);
          }
        } else {
          */
          // Realiza una solicitud POST para crear un nuevo libro
          const res = await axios.put(`/libros/${bookEdit.id}`, book);
          if (res.status === 200) {
            setBookEdit(res.data);
          }
        //}
      } catch (e) {
        console.log(e);
      }
    };

  return (
    <div>
      <bookcontext.Provider>
            <BookFormEdit addBook={addBook} bookEdit={bookEdit}/>
        </bookcontext.Provider>
    </div>
  )
}

export default EditBook
