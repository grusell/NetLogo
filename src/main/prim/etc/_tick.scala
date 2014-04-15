// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Command, Context }

class _tick extends Command {
  override def syntax2 =
    Syntax.commandSyntax(
      agentClassString = "O---",
      switches = true)
  override def callsOtherCode = true
  override def perform(context: Context) {
    workspace.tick(context, this)
    context.ip = next
  }
}
