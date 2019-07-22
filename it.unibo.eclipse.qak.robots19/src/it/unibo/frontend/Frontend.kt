/* Generated by AN DISI Unibo */ 
package it.unibo.frontend

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Frontend ( name: String, scope: CoroutineScope ) : ActorBasicFsm( name, scope){
 	
	override fun getInitialState() : String{
		return "s0"
	}
		
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						itunibo.console.guiSupport.create(myself ,"local_userCmd" )
					}
					 transition( edgeName="goto",targetState="handleUserCmd", cond=doswitch() )
				}	 
				state("handleUserCmd") { //this:State
					action { //it:State
					}
					 transition(edgeName="t00",targetState="sendToRobot",cond=whenEvent("local_userCmd"))
					transition(edgeName="t01",targetState="sendToRobot",cond=whenEvent("envCond"))
				}	 
				state("sendToRobot") { //this:State
					action { //it:State
						println("$name in ${currentState.stateName} | $currentMsg")
						if( checkMsgContent( Term.createTerm("local_userCmd(X)"), Term.createTerm("local_userCmd(MOVE)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								println("frontend handling local_userCmd( ${payloadArg(0)} )")
								emit("userCmd", "userCmd(${payloadArg(0)})" ) 
						}
						if( checkMsgContent( Term.createTerm("envCond(CONDTYPE)"), Term.createTerm("envCond(COND)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								println("frontend handling envCond( ${payloadArg(0)} )")
						}
					}
					 transition( edgeName="goto",targetState="handleUserCmd", cond=doswitch() )
				}	 
			}
		}
}