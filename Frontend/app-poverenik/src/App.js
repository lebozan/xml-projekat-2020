import './App.css';
import * as React from 'react';
import Root from "./components/Root";
import { BrowserRouter } from "react-router-dom";
import PoverenikContext from './context/poverenik-context';



class App extends React.Component {
	state = {
	};



	render() {
		return (
			<PoverenikContext.Provider 
			value={{

			}}>
				<BrowserRouter>
					<Root />
				</BrowserRouter>
			</PoverenikContext.Provider>
		);
	}
}

export default App;
