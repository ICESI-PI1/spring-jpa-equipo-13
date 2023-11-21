import { useContext, useEffect, useState } from 'react'
import { Form, FormGroup, Button, Label, Input, FormText} from 'reactstrap'
import PropTypes from 'prop-types'
import { Link } from 'react-router-dom';
import {bookcontext} from '../context/BookContext';
import axios from  '../config/axios'



const BookForm = ({addBook, bookEdit}) => {

    const[id, setId]=useState('')
    const[title, setTitle]= useState('')
    const[publicationDate, setPublicationDate]= useState('')
    const[authorId, setAuthorId]= useState('')   
    const[al, setAl]= useState('')
    const[authorList, setAuthorList]= useState(null)
    const {alert} = useContext(bookcontext)
    
    useEffect(()=>{
        setAl(alert)
    },[alert])

    useEffect(()=>{
        setId(bookEdit.id)
        setTitle(bookEdit.title)
        setPublicationDate(bookEdit.publicationDate)
        setAuthorId(bookEdit.authorId)
        //console.log(bookEdit.authorId)
    }, [bookEdit])

    const getOneAuthor = async (author) =>{
        try{
            const res = await axios.get(`/autores/${author}`)
            setAuthorList(res.data)
            //console.log(res.data)
        }catch (e){
            console.log(e)
        }
    }

    
    
    const handleClick = () => {
        getOneAuthor(authorId)
        addBook({ id, title, publicationDate, authorId });
        window.alert(alert)
    };

  return (   
    <Form>
        <h1>Creacion de un libro</h1>
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks"> Numero de identificacion </Label>
            <Input id="idBook" name="idBook" placeholder="id" type="text" onChange={(e)=>{setId(e.target.value)}} />
        </FormGroup>
        
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Titulo del libro </Label>
            <Input id="bookTitle" name="tittle" placeholder="Titulo" type="text" onChange={(e)=>{setTitle(e.target.value)}}/>
        </FormGroup>
              <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Fecha de publicacion </Label>
            <Input id="bookPublicationDate" name="publicationDate" placeholder="fecha de publicacion" type="date" onChange={(e)=>{setPublicationDate(e.target.value)}}/>
        </FormGroup>
        
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Numero de identificacion del autor </Label>
            <Input id="idAuthor" name="idAuthor" placeholder="id autor" type="text" onChange={(e)=>{setAuthorId(e.target.value)}}> console.log(e.target.value)</Input>
        </FormGroup>
        
        <Link to="/libros">
        <Button style={{
            width: '100%'
        }} color='primary' onClick={handleClick}>
            Enviar
        </Button>
        </Link>
        {al && (
  <div className="alert alert-danger" role="alert">
    {al}
  </div>
)}
    </Form>
  )
}

BookForm.propTypes = {
    addBook: PropTypes.func, 
    bookEdit:PropTypes.object,
}

export default BookForm
