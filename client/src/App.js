import React from 'react';
import './style/Styles.css';
import Bicycles from "./component/Bicycles";

//import { Icon, Input } from 'semantic-ui-react';


class App extends React.Component {

    render() {
        return (
            <div className='app-div'>
                <div className='search-div'>
                    <div className='bike-shop-name'>
                        Vrum-Vrum Bikes
                    </div>
                    <div className='search-input'>
                        <input placeholder={"Search"} type="text" className='search'/>
                        <input className={'search-button'} type="submit" value="Submit"/>
                    </div>
                </div>
                <div className={'h1div'}>
                    <div>
                        <h1 className={'h1-text'}>
                            Top five bikes
                        </h1>
                    </div>
                </div>
                <div className={'bike-table'}>
                    <Bicycles/>
                </div>
            </div>
        )
    }
}

export default App;

