import React from 'react';



export default class Bicycles extends React.Component {

    render() {
        return (
            <div className={'bike-table'}>
                {this.props.arr}
            </div>
        )
    }
}
