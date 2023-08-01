import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useState } from 'react';
import Row from 'react-bootstrap/esm/Row';
import Col from 'react-bootstrap/esm/Col';
import { useNavigate } from 'react-router-dom';

const OneDogDetail = (props) => {

  const[counter, setCounter] = useState(0);

  const incrementCounter =()=>{
    setCounter(counter+1);
    props.parentCount(props.info.name);
  }

  return (
    <Card >
      <Card.Body >
        <Card.Title >Name: {props.info.name}</Card.Title>
        <Card.Text >Age: {props.info.age}</Card.Text>
        <Row>
        <Col><Button variant="primary" onClick={incrementCounter}>Like</Button></Col>
        <Col>{counter > 0  && <Card.Text >Likes: {counter}</Card.Text > }</Col>
        </Row>
      </Card.Body>
    </Card>
  )

}



export default OneDogDetail