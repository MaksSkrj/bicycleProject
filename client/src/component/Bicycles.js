import React from 'react';
import Bike from "./Bike";



export default class Bicycles extends React.Component {

    render() {
        return (
            <div className={'bike-table'}>
                {this.props.bikes.map((bike) => {
                    return <Bike bike={bike} key={bike.productId}/>
                })}
            </div>
        )
    }
}
