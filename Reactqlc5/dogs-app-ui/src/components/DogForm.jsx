import React from 'react'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/esm/Row'
import Button from 'react-bootstrap/esm/Button'
import { useState } from 'react'
import { saveDog } from '../services/dog-service';



const DogForm = () => {
    //const [alias, setAlias] = useState('');
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    //const [teamID, setTeamID] = useState(0);

    let dog = {};
    dog.name = name;
    dog.age = age;


    const handleNameChange = (event)=>{
        setName(event.target.value);
    }

    const handleAgeChange = (event)=> {
        setAge(event.target.value);
    }




    const handleSubmit =(event)=>{
        event.preventDefault();
        let dog = {};
        dog.name = name;
        dog.age = age;

        saveDog(dog)
          .then(res => {
             setName('');
             setAge(0)
             })
           .catch(err=>{
              console.log(err);
             })   
       }

    return (
        <Row className='dogForm'>
            <Form >
                <Form.Group className="mb-3" controlId="name">
                    <Form.Label>Dog Name: </Form.Label>
                    <Form.Control type="text" placeholder="Dog name" value={name}
                    onChange={handleNameChange} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="age">
                    <Form.Label>Dog Age: </Form.Label>
                    <Form.Control type="text" placeholder="Dog age" value={age}
                    onChange={handleAgeChange}/>
                </Form.Group>
                <Button variant="primary" type="submit" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </Row>
    )
}


export default DogForm