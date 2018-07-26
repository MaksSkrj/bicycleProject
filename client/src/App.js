import React from 'react';
import './style/Styles.css';
import Bicycles from "./component/Bicycles";


class App extends React.Component {
    render() {
        return (
            <div className='app-div'>
                <div className='search-div'>
                    <text className='bike-shop-name'>Vrum-Vrum Bikes</text>
                    <div className='search-input'>
                        <input placeholder={"Search"} type="text" className='search'/>
                        <input type="submit" value="Submit"/>
                    </div>
                </div>
                <div>
                    <Bicycles/>
                </div>
            </div>
        )
    }
}

export default App;

