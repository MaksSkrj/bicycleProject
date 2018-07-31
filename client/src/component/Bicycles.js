import React from 'react';
import Bike from "./Bike";
import axios from 'axios'

export default class Bicycles extends React.Component {

    render() {
        return (
            <div>
                <div>{this.props.arr}</div>
            </div>
        )
    }

}
