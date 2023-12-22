import ContactList from './contactList.jsx'
import React, { useState, useEffect } from 'react';
import Message from './message.jsx'



export default function TabCondent({ component }) {
    console.log(component)
    if (component==="Contacts") {

        return <ContactList ></ContactList>
    }
    if (component === "Messaging") {

        return <Message>this is yet to be developed</Message>
    }
}

