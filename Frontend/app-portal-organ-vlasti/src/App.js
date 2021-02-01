import './App.css';
import * as React from 'react';
import Root from "./components/Root";
import { BrowserRouter } from "react-router-dom";
import PortalContext from './context/portal-context';



class App extends React.Component {
	state = {
	};



	render() {
		return (
			<PortalContext.Provider 
			value={{

			}}>
				<BrowserRouter>
					<Root />
				</BrowserRouter>
			</PortalContext.Provider>
		);
	}
}

export default App;
