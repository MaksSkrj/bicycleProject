import React from 'react';
import {Card, Icon, Button, Image, Modal, Header} from 'semantic-ui-react'
import {getPictureRes} from '../actions/BikeActions'
import ProductDetails from '../component/ProductDetails'

export default class Bike extends React.Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentWillMount() {
        this.getPhotoById()
    }

    // componentWillReceiveProps(nextProps) {
    //     console.log("props")
    //     if (nextProps.bikes !== this.props.bikes) {
    //         //Perform some operation
    //         this.render()
    //     }
    // };

    getPhotoById = () => {
        getPictureRes(this.props.bike.productId)
            .then(res =>
                this.setState({
                        photo: res[0].largePhoto
                    }
                ))
    };

    render() {
        const {name, modifiedDate, listPrice} = this.props.bike;
        return (
            <div className={'bike-cell'}>
                <Card className={'card'}>
                    <img className={'bike-picture'}
                         src={(this.state.photo) ? `data:image/jpeg;base64,${this.state.photo}` : console.log("no photo for bike")}/>
                    <Card.Content>
                        <Card.Header>{name}</Card.Header>
                        <Card.Meta>
                            <span className='date'>{modifiedDate}</span>
                        </Card.Meta>
                    </Card.Content>
                    <Card.Content extra>
                        <Icon name='money'/> {listPrice}
                        <ProductDetails bike={this.props.bike} photo={this.state.photo}/>
                    </Card.Content>
                </Card>
            </div>
        );
    };
}
