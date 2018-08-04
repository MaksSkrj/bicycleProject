import React from 'react';
import {Card, Icon, Button, Image, Modal, Header} from 'semantic-ui-react'
import {getPictureRes} from '../actions/BikeActions'

export default class Bike extends React.Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentWillMount() {
        this.getPhotoById()
    }

    getPhotoById = () => {
        getPictureRes(this.props.bike.productId)
            .then(res =>
                this.setState({
                        photo: res[0].largePhoto
                    }
                ))
    };

    render() {

        console.log("AAAA BLYA")
        const {name, modifiedDate, listPrice, productNumber, color, size, weight, productLine, clazz, style} = this.props.bike;
        return (
            <div className={'bike-cell'}>
                <Card className={'card'}>
                    <img className={'bike-picture'} src={`data:image/jpeg;base64,${this.state.photo}`}/>
                    <Card.Content>
                        <Card.Header>{name}</Card.Header>
                        <Card.Meta>
                            <span className='date'>{modifiedDate}</span>
                        </Card.Meta>
                    </Card.Content>
                    <Card.Content extra>
                        <Icon name='money'/> {listPrice}
                        {/*Here modal code sorry*/}
                        <Modal trigger={<Button floated={'right'} className={'details'}>Details</Button>} closeIcon>
                            <Modal.Header>Information</Modal.Header>
                            <Modal.Content image>
                                <Image wrapped size='medium' src={`data:image/jpeg;base64,${this.state.photo}`}/>
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
                        {/**/}
                    </Card.Content>
                </Card>
            </div>
        );
    };
}
