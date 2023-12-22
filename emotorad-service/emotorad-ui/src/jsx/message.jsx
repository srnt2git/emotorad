import React, { useEffect, useState } from 'react';
import { useFetch } from './httpClient.jsx'
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import PostMessage from './postMessage.jsx'

export default function Messaging() {
    const [message, setMessage] = useState({ speed: '100' });
    const [render, setRender] = useState();
    const [openAddDialog, handleAddDisplay] = useState(false);
    useFetch('message/getMessage', (data) => {
        setMessage(data[0])       
    }, () => { }, render)
    const openAddDialogBox = () => {
        handleAddDisplay(true);
    };
    const handleAddClose = () => {
        handleAddDisplay(false);
        setRender(!render)
     };
  
    return (<><table>
        <thead>
        <tr>
            <th>Post Message: 
            </th>
                <th>
                    <button onClick={openAddDialogBox}> Post</button>
            </th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>speed</td>
                <td>{message.speed}</td>
            </tr>
        </tbody>
        
        
    </table>

        <Dialog onClose={handleAddClose}
            open={openAddDialog} >
            <DialogTitle>Post Message</DialogTitle>
            <PostMessage closeDialog={handleAddClose}></PostMessage>
        </Dialog>
    </>);
}