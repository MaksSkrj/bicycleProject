import React from 'react';
import {Icon, Button, Image, Modal, Header} from 'semantic-ui-react'

export default class ProductDetails extends React.Component {
    render() {
        const  {name, modifiedDate, productNumber, color, size, weight, productLine, clazz, style} = this.props.bike;
        return (
            <div>
                <Modal trigger={<Button floated={'right'}>Details</Button>} closeIcon>
                    <Modal.Header>Information</Modal.Header>
                    <Modal.Content image>
                        <Image wrapped size='medium' src={`data:image/jpeg;base64,${this.props.photo}`}/>
                        <Modal.Description>
                            <Header><b>{name}</b></Header>
                            <p><b>Number: </b> {productNumber}</p>
                            <p><b>Color: </b> {color} </p>
                            <p><b>Size: </b> {size}</p>
                            <p><b>Weight: </b> {weight}</p>
                            <p><b>Product Line: </b> {productLine}</p>
                            <p><b>Class: </b> {clazz}</p>
                            <p><b>Style: </b> {style}</p>
                            <p><b>Modified date: </b> {modifiedDate}</p>
                        </Modal.Description>
                    </Modal.Content>
                    <Modal.Actions>
                        <Button color='red'>
                            <Icon name='remove'/> Delete
                        </Button>
                    </Modal.Actions>
                </Modal>
            </div>
        )
    }
}