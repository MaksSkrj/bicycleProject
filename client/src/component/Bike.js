import React from 'react';
import axios from 'axios';

export default class Bike extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            productId: props.data.productId,
            productPhotoId: null,
            thumbNailPhoto: null,
            thumbNailPhotoFileName: null,
            largePhoto: null,
            largePhotoFileName: null,
            modifiedDate: null
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
        return (
            <div className={'bike-cell'} id={'topFive'}>
                <div className={"bike-photo"}>
                    <span className={'top-five-span'}>
                        <div className={'color-div'}>Color: {this.props.data.color}</div>
                        <div>Size: {this.props.data.size}</div>
                        <div>Weight: {this.props.data.weight} kg</div>
                        <div>Class: {this.props.data.clazz}</div>
                    </span>
                    <img className={'bike-picture'} src={`data:image/jpeg;base64,${this.state.largePhoto}`}/><br/>
                </div>
                <div className={'bike-name-div'}>
                    <div id={"name"}>{this.props.data.name}</div>
                </div>
                <div className={'price-div'}>
                    <div>Price: {this.props.data.listPrice}$</div>
                </div>
            </div>
        );
    };
}