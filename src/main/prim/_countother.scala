// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.agent.AgentSet
import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Reporter, Context }

class _countother extends Reporter {

  override def syntax2 =
    Syntax.reporterSyntax(
      right = List(Syntax.AgentsetType),
      ret = Syntax.NumberType,
      agentClassString = "-TPL")

  override def report(context: Context): java.lang.Double =
    Double.box(report_1(context, argEvalAgentSet(context, 0)))

  def report_1(context: Context, arg0: AgentSet): Double = {
    var result = 0
    val iter = arg0.iterator
    while(iter.hasNext)
      if (iter.next() ne context.agent)
        result += 1
    result
  }

}
