package testProva


import org.junit.After
import org.junit.Before
import org.junit.Test
import alice.tuprolog.SolveInfo
import it.unibo.kactor.sysUtil
import it.unibo.kactor.ActorBasic
import it.unibo.kactor.MsgUtil
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay

import org.junit.Assert.*
import org.junit.runners.JUnit4


public class testProva {
	
	var robot : ActorBasic? = null
	
	@Before
	@Throws(Exception::class)
	fun systemSetUp() {
		println(" %%%%%%% TestRobotmindnomvc starts its job  %%%%%% ")
		//if( ! startUpDone ){
 		/*
            IT IS NOT NECESSARY TO START the basic robot.
 			In any case the basic robot must be lanched from a another isntance of JVM
        */			
	 		GlobalScope.launch{
 			    println(" %%%%%%% TestRobotmindnomvc starts robot mind ")
//				it.unibo.ctxRobotMindNoMv.main()
				it.unibo.ctxBasicRobot.main()
		
			}
	 		delay(20000)	 
			/*
			startUpDone = true;
			getActors()*/
			//robot = sysUtil.getActor("robotmindnomvc")
			robot = sysUtil.getActor("basicrobot")	 		
		    println(" %%%%%%% TestRobotmindnomvc starts its job $robot %%%%%% ")
		
		//}
 	}
	
	@Test fun testFunction() {  

		//robot = sysUtil.getActor("robotmindnomvc")
		
		/*var pippo = true
		var pluto = true
		assertTrue(pippo)
		assertTrue(pluto)*/
		
		/*GlobalScope.launch{
 			    println("Provo a lanciare la mind")
				it.unibo.ctxRobotMindNoMv.main()
 		}*/	
		moveRobot(robot!!, "w", 5000)
		
	}
	
	fun moveRobot( actor : ActorBasic, move : String, time : Long ){
		actor.scope.launch{
			//println("emit robotCmd($move)")
			//robot!!.emit("userCmd","userCmd($move)") //simulate the effect of an user command
			MsgUtil.sendMsg("robotCmd","robotCmd($move)",robot!!)
			
 		}
		delay(time) //give time to do the move
  	}
	
	fun delay( time : Long ){
		Thread.sleep( time )
	}
	
}
