// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.headless

import org.nlogo.api.{ CompilerException, Version }
import org.nlogo.core.Resource.getResourceAsString
import org.nlogo.workspace, workspace.AbstractWorkspace.setHeadlessProperty

object Shell extends workspace.Shell {
  val modelSuffix = "nlogo"
  val emptyModelPath = "/system/empty." + modelSuffix

  def main(argv: Array[String]) {
    setHeadlessProperty()
    System.err.println(Version.fullVersion)
    val workspace = HeadlessWorkspace.newInstance
    argv.headOption match {
      case None =>
        workspace.open(emptyModelPath)
      case Some(path) =>
        workspace.open(path)
    }
    input.takeWhile(!isQuit(_))
      .foreach(run(workspace, _))
    workspace.dispose()
  }

  def run(workspace: HeadlessWorkspace, line: String) {
    val command =
      if (workspace.isReporter(line))
        "print " + line
      else
        line
    try workspace.command(command)
    catch {
      case ex: CompilerException =>
        println("COMPILER ERROR: " + ex.getMessage)
        ex.printStackTrace()
      case ex: org.nlogo.nvm.EngineException =>
        val msg = ex.context.buildRuntimeErrorMessage(ex.instruction, ex)
        println("RUNTIME ERROR: " + msg)
        ex.printStackTrace()
      case ex: org.nlogo.api.LogoException =>
        println("RUNTIME ERROR: " + ex.getMessage)
        ex.printStackTrace()
    }
  }

}
