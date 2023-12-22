import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import { useCallback, useState } from 'react';
import styles from "./../css/DialogStyles.module.css"
import { useFetch, del } from "./httpClient"
import { useJwt } from './jwtcontext';
import AddContact from './addContact';
export default function ContactList() {   
    const [openAddDialog, handleAddDisplay] = useState(false);
    const [selectedRow, setSelectedRow] = useState();
    const [rerender, setRerender] = useState(false);
    const { getJwt } = useJwt();
    const [contacts, setContacts] = useState(
        [{
            id: 1,
            email: 'simple@gmail.com',
            phoneNumber: '+911203948587',
           

        }]
    );
    const openAddDialogBox = () => {
        handleAddDisplay(true);
    };
    const handleAddClose = () => {
        handleAddDisplay(false);
        //console.log("rerender"+rerender)
        setRerender(true);

    };
    const handleResponse = useCallback((data) => {
        console.log(data.contacts)
        updateContacts(data);
        setRerender(false);
    });
    useFetch('user/findByMail', handleResponse, ((err) => {
        setRerender(false);
        // console.log(err)
    }), rerender);

    const updateContacts = (contacts) => {
            setContacts(contacts);
    }   

    return (<>
        <table >
            <thead>
                <tr>
                    <th colSpan="3">
                        Add Contact: <button onClick={openAddDialogBox} >Add</button>
                    </th>                    
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Phone Number</th>                  
                </tr>
            </thead>
            <tbody>
                {contacts.length > 0 ?
                    contacts.map(contact => {
                        return <>
                            <tr>                               
                                <td>{contact.id}</td>
                                <td>{contact.email}</td>
                                <td>{contact.phoneNumber}</td>
                                
                            </tr>
                        </>
                    }) : <tr>
                        <td colSpan="4" >no data</td>
                    </tr>
                }
            </tbody>
        </table>
        <Dialog onClose={handleAddClose}
            open={openAddDialog}
            className={styles.customDialog}>
            <DialogTitle>Add Contact </DialogTitle>
            <AddContact book={selectedRow}
                closeDialog={handleAddDisplay}
                className={styles.customDialogContent} />
        </Dialog>
    </>);
}