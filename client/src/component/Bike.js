import React from 'react';
import axios from 'axios';
import { Card, Icon, Button, Image, Modal, Header } from 'semantic-ui-react'

import PropTypes from 'prop-types';




export default class Bike extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            productId: props.data.productId,
        }
    }



    componentDidMount() {
        axios
            .get('http://localhost:8080/photo/get/' + this.state.productId)
            .then(({data}) => {
                this.setState({
                    productPhotoId: data[0].productPhotoId,
                    thumbNailPhoto: data[0].thumbNailPhoto,
                    thumbNailPhotoFileName: data[0].thumbNailPhotoFileName,
                    largePhoto: data[0].largePhoto,
                    largePhotoFileName: data[0].largePhotoFileName,
                    modifiedDate: data[0].modifiedDate
                });
                console.log(data)
            });
    }


    render() {
        const {fullScreen } = this.props;
        return (
            <div className={'bike-cell'}>
                <Card className={'card'}>
                    <img className={'bike-picture'} src={`data:image/jpeg;base64,${this.state.largePhoto}`}/>
                    <Card.Content>
                        <Card.Header>{this.props.data.name}</Card.Header>
                        <Card.Meta>
                            <span className='date'>{this.props.data.modifiedDate}</span>
                        </Card.Meta>
                    </Card.Content>
                    <Card.Content extra>
                            <Icon name='money' />
                            {this.props.data.listPrice} $
                    </Card.Content>
                </Card>
                <Modal trigger={<Button className={'delete-button'}>View Details</Button>} closeIcon>
                    <Modal.Header>Information</Modal.Header>
                    <Modal.Content image>
                        <Image wrapped size='medium' src={`data:image/jpeg;base64,${this.state.largePhoto}`} />
                        <Modal.Description>
                            <Header><b>{this.props.data.name}</b></Header>
                            <p><b>Number: </b> {this.props.data.productNumber}</p>
                            <p><b>Color: </b> {this.props.data.color} </p>
                            <p><b>Size: </b> {this.props.data.size}</p>
                            <p><b>Weight: </b> {this.props.data.weight}</p>
                            <p><b>Product Line: </b> {this.props.data.productLine}</p>
                            <p><b>Class: </b> {this.props.data.clazz}</p>
                            <p><b>Style: </b> {this.props.data.style}</p>
                            <p><b>Modified date: </b> {this.props.data.modifiedDate}</p>
                        </Modal.Description>
                    </Modal.Content>
                    <Modal.Actions></Modal.Actions>
                </Modal>
                <Button className={'delete-button'}>Delete Product</Button>
            </div>
        );
    };



}

Bike.propTypes = {
    fullScreen: PropTypes.bool.isRequired,
};