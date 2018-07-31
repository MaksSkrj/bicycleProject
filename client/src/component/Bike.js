import React from 'react';
import axios from 'axios';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import PropTypes from 'prop-types';




export default class Bike extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            productId: props.data.productId,
            open: false,
        }
    }

    op = () => {
        this.setState((prev)=> {
            open: !prev
        })
    }

    handleClickOpen = () => {
        this.setState({ open: true });
    };

    handleClose = () => {
        this.setState({ open: false });
        console.log("AAAAAAAAAAAAAAAAAAAAA",this.state.open)
    };

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

            <div className={'bike-cell'} id={'topFive'} onClick={this.handleClickOpen}>
                <div>
                    <Dialog
                        fullScreen={fullScreen}
                        open={this.state.open}
                        onClose={this.handleClose}
                        aria-labelledby="responsive-dialog-title"
                    >
                        <DialogTitle id="responsive-dialog-title">{this.props.data.name}</DialogTitle>
                        <DialogContent>
                            <DialogContentText>
                                <div>
                                    <img className={'bike-picture'} src={`data:image/jpeg;base64,${this.state.largePhoto}`}/><br/>
                                </div>
                                <div className={'test'}>
                                    <b>Number:</b> {this.props.data.productNumber} <br/>
                                    <b>Color:</b> {this.props.data.color} <br/>
                                    <b>Size:</b> {this.props.data.size}<br/>
                                    <b>Weight:</b> {this.props.data.weight}<br/>
                                    <b>Product Line:</b> {this.props.data.prodictLine}<br/>
                                    <b>Class:</b> {this.props.data.clazz}<br/>
                                    <b>Style:</b> {this.props.data.style}<br/>
                                    <b>Modified date:</b> {this.props.data.modifiedDate}
                                </div>
                            </DialogContentText>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={this.handleClose} color="primary">
                                Close
                            </Button>
                        </DialogActions>
                    </Dialog>
                </div>
                <div className={"bike-photo"}>
                    <img className={'bike-picture'} src={`data:image/jpeg;base64,${this.state.largePhoto}`}/><br/>
                    <div className={'top-five-info'}>
                        <div className={'color-div'}>Color: {this.props.data.color}</div>
                        <div>Size: {this.props.data.size}</div>
                        <div>Weight: {this.props.data.weight} kg</div>
                        <div>Class: {this.props.data.clazz}</div>
                    </div>
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

Bike.propTypes = {
    fullScreen: PropTypes.bool.isRequired,
};