import {useEffect, useState} from 'react'
//import tasks from  '../data/todos.json'
import axios from  '../config/axios'
import AuthorForm from '../components/AuthorForm'
import { bookcontext } from '../context/bookcontext'

function CreateAuthorList(){

   
    const[authorEdit, setAuthorEdit]= useState({id:"", name:"", nationality:""})

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
        <bookcontext.Provider>
            <AuthorForm addAuthor={addAuthor} authorEdit={authorEdit}/>
        </bookcontext.Provider>
    )
}

export default CreateAuthorList