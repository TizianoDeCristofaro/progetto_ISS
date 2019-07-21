/* Generated by AN DISI Unibo */ 
package it.unibo.smartphone

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Smartphone ( name: String, scope: CoroutineScope ) : ActorBasicFsm( name, scope){
 	
	override fun getInitialState() : String{
		return "s0"
	}
		
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						println("USING SMARTPHONE")
					}
					 transition( edgeName="goto",targetState="waitUser", cond=doswitch() )
				}	 
				state("waitUser") { //this:State
					action { //it:State
						println("Smartphone waiting for user")
						delay(1000) 
						emit("userCmd", "userCmd(CIAO)" ) 
					}
					 transition(edgeName="t00",targetState="send",cond=whenEvent("userCmd"))
				}	 
				state("send") { //this:State
					action { //it:State
						println("Smartphone sending information")
						forward("searchCmd", "searchCmd(5)" ,"fridge" ) 
					}
					 transition( edgeName="goto",targetState="waitAnswer", cond=doswitch() )
				}	 
				state("waitAnswer") { //this:State
					action { //it:State
						println("Smartphone waiting for an answer")
					}
					 transition(edgeName="t11",targetState="show",cond=whenDispatch("fridgeMsg"))
				}	 
				state("show") { //this:State
					action { //it:State
						println("Smartphone showing information")
					}
					 transition(edgeName="t22",targetState="waitUser",cond=whenEvent("userCmd"))
				}	 
			}
		}
}
