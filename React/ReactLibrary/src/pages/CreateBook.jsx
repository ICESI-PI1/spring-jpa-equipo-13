import { useEffect, useState } from 'react'
import BookForm from '../components/BookForm'
import axios from  '../config/axios'
import { bookcontext } from '../context/BookContext'


const CreateBook = () => {
  const[bookEdit, setBookEdit]= useState({id:"", title:"", publicationDate:"", authorId: ""})
  const[alert, setAlert]= useState("")
  const addBook = async (book) => {
    setAlert("probando")
    try {
       
        const res = await axios.post("/libros", book);
        console.log(res)
        if (res.status !== 201) {
          setAlert("probando");
          console.log("probando");
        }
        if (res.status === 201) {
          setBookEdit(res.data);
        }
    } catch (e) {
      setAlert("probando");
      console.log(alert);

      console.log(e);
    }
  };

  return (
      <bookcontext.Provider value={{alert,setAlert}}>
          <BookForm addBook={addBook} bookEdit={bookEdit}  />
      </bookcontext.Provider>
  )
}

export default CreateBook
