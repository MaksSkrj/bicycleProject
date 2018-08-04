import React from 'react';
import {Icon, Button, Input, Modal, Header} from 'semantic-ui-react'

export default class NewProductModal extends React.Component {
    render() {
        return(
            <div className={'function-buttons'}>
                <Modal trigger={<Button inverted className={'function-buttons'}>Add Product</Button>} closeIcon>
                    <Modal.Header>Create New Product</Modal.Header>
                    <Modal.Content>
                        <Modal.Description>
                            <Input className={'insert-input'} placeholder={'Name'}/>
                            <Input className={'insert-input'} placeholder={'Product Number'}/>
                            <Input className={'insert-input'} placeholder={'Finished Goods'}/>
                            <Input className={'insert-input'} placeholder={'Color'}/>
                            <Input className={'insert-input'} placeholder={'Safety Stock Level'}/>
                            <Input className={'insert-input'} placeholder={'Reorder Point'}/>
                            <Input className={'insert-input'} placeholder={'Standard Cost'}/>
                            <Input className={'insert-input'} placeholder={'List Price'}/>
                            <Input className={'insert-input'} placeholder={'Size'}/>
                            <Input className={'insert-input'} placeholder={'Weight'}/>
                            <Input className={'insert-input'} placeholder={'Product Line'}/>
                            <Input className={'insert-input'} placeholder={'Class'}/>
                            <Input className={'insert-input'} placeholder={'Style'}/>
                        </Modal.Description>
                    </Modal.Content>
                    <Modal.Actions>
                        <Button color='green'>
                            <Icon name='pencil alternate'/> Add
                        </Button>
                    </Modal.Actions>
                </Modal>
            </div>



        )
    }
}