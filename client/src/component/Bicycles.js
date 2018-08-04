import React from 'react';
import Bike from "./Bike";



export default class Bicycles extends React.Component {

    render() {
        console.log("AAAAAAA")
        return (
            <div className={'bike-table'}>
                {this.props.bikes.map((bike) => {
                    console.log('bike', bike)
                    return <Bike bike={bike}/>
                })}
            </div>
        )
    }
}
