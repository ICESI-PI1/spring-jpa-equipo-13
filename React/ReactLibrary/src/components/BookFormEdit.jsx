import React from 'react'
import {useEffect, useState} from 'react'
import { Form, FormGroup, Button, Label, Input, FormText} from 'reactstrap'
import { Link , useParams } from 'react-router-dom';

const BookFormEdit = ({addBook, bookEdit}) => {

    console.log(bookEdit)

    const[id, setId]=useState('')
    const[title, setTitle]= useState('')
    const[publicationDate, setPublicationDate]= useState('')
    const[authorId, setAuthorId]= useState('')   
    
    useEffect(()=>{
        setId(bookEdit.id)
        setTitle(bookEdit.title)
        setPublicationDate(bookEdit.publicationDate)
        setAuthorId(bookEdit.authorId)
    }, [bookEdit])
    
    const handleClick = () =>{
        //console.log({id,title, publicationDate, authorId})
        addBook({id,title,publicationDate, authorId})
    }

  return (
    <>
     <Form>
        <h1>Edicion de un libro</h1>
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks"> Numero de identificacion </Label>
            <Input id="idBook" name="idBook" placeholder="id" type="text" value={bookEdit.id} onChange={(e)=>{setId(e.target.value)}} />
        </FormGroup>
        
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Titulo del libro </Label>
            <Input id="bookTitle" name="tittle" placeholder="Titulo" type="text" value={title} onChange={(e)=>{setTitle(e.target.value)}}/>
        </FormGroup>
              <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Fecha de publicacion </Label>
            <Input id="bookPublicationDate" name="publicationDate" placeholder="fecha de publicacion" value={publicationDate} type="date" onChange={(e)=>{setPublicationDate(e.target.value)}}/>
        </FormGroup>
        
        <FormGroup>
            <Label style={{
            display: 'flex'
        }} for="exampleBooks" > Numero de identificacion del autor </Label>
            <Input id="idAuthor" name="idAuthor" placeholder="id autor" type="text" value={authorId} onChange={(e)=>{setAuthorId(e.target.value)}}/>
        </FormGroup>
        
        <Link to="/libros">
        <Button style={{
            width: '100%'
        }} color='primary' onClick={handleClick}>
            Enviar
        </Button>
        </Link>
    </Form>
    </>
  )
}

export default BookFormEdit
