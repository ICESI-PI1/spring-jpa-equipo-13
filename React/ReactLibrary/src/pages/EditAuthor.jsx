import React from 'react'
import BookFormEdit from '../components/BookFormEdit'
import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import AuthorForm from '../components/AuthorForm'
import { bookcontext } from '../context/bookcontext'
import BookForm from '../components/BookForm'
import AuthorFormEdit from '../components/AuthorFormEdit'
import { Link , useParams } from 'react-router-dom';

const EditAuthor = () => {

    
    let {idAuthor} = useParams();

    const[authorEdit, setAuthorEdit]= useState({id:"", name:"", nationality:""})

    useEffect(() => {
        getAuthor();
    }, []);
    

    const getAuthor = async () => {
        try {
            const res = await axios.get(`/autores/${idAuthor}`)
            if(res.status == 200){
                //console.log("YESSS")
                setAuthorEdit(res.data)
            }
        } catch (e) {
            console.log(e);
        }
    }

    const addAuthor = async (author) => {
        try {
            
            if (authorEdit.id) {
            
                const res = await axios.put(`/autores/${authorEdit.id}`, author);
                if (res.status === 200) {
                    setAuthorEdit(res.data);
                }
            } else {
            
            const res = await axios.post("/autores", author);
                if (res.status === 201) {
                    setAuthorEdit(res.data);
                }
            }
        } catch (e) {
            console.log(e);
        }
    };

  return (
    <div>
      <bookcontext.Provider>
          <AuthorFormEdit addAuthor={addAuthor} authorEdit={authorEdit}/>
      </bookcontext.Provider>
    </div>
  )
}

export default EditAuthor
