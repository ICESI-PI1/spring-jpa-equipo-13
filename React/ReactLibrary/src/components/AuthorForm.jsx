import { useEffect, useState } from 'react'
import PropTypes from 'prop-types'
import { Form, FormGroup, Button, Label, Input, FormText} from 'reactstrap'
import { Link } from 'react-router-dom';


function AuthorForm({addAuthor, authorEdit}){

    const[id, setId]=useState('')
    const[name, setName]= useState('')
    const[nationality, setNationality]= useState('')
    
    useEffect(()=>{
        setId(authorEdit.id)
        setName(authorEdit.name)
        setNationality(authorEdit.nationality)
    }, [authorEdit])
    
    const handleClick = () =>{
        console.log({id,name,nationality})
        addAuthor({id,name,nationality})
    }

    const buttonStyle = {
        backgroundColor: 'blue',
        color: 'white',
        padding: '10px 20px',
        border: 'none',
        borderRadius: '5px',
        width: '100%'
    };

      

    return(
        <Form>
            <h1 style={{
                fontSize: '35px', 
                marginBottom: '30px'
            }} >Agregar un Autor</h1>
            
            <FormGroup>
                <Label style={{
                        display: 'flex'
                    }} for="exampleName">Nombre del autor</Label>
                <Input id="exampleName" name="Name" placeholder="Nombre" type="Name" onChange={(e)=>{setName(e.target.value)}}/>
            </FormGroup>
            <FormGroup>
                <Label style={{
                        display: 'flex'
                    }} for="exampleN">Nacionalidad</Label>
                <Input id="exampleN" name="Name" placeholder="Nacionalidad" type="Name" onChange={(e)=>{setNationality(e.target.value)}}/>
            </FormGroup>
            <Link to="/autores">
            <Button onClick={handleClick} style={buttonStyle}>
                Submit
            </Button>
            </Link>
        </Form>
    )
}

AuthorForm.propTypes = {
    addAuthor: PropTypes.func, 
    authorEdit:PropTypes.object
}

export default AuthorForm