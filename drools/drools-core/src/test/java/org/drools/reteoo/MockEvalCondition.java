package org.drools.reteoo;
/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import org.drools.WorkingMemory;
import org.drools.rule.Declaration;
import org.drools.rule.EvalCondition;
import org.drools.spi.EvalExpression;
import org.drools.spi.Tuple;

public class MockEvalCondition extends EvalCondition {

    private static EvalExpression trueExpression  = new EvalExpression() {
                                                      public boolean evaluate(Tuple tuple,
                                                                              Declaration[] requiredDeclarations,
                                                                              WorkingMemory workingMemory) {
                                                          return true;
                                                      }
                                                  };

    private static EvalExpression falseExpression = new EvalExpression() {
                                                      public boolean evaluate(Tuple tuple,
                                                                              Declaration[] requiredDeclarations,
                                                                              WorkingMemory workingMemory) {
                                                          return false;
                                                      }
                                                  };

    public MockEvalCondition(boolean isAllowed) {
        this( isAllowed,
              null );
    }

    public MockEvalCondition(boolean isAllowed,
                             Declaration[] requiredDeclarations) {
        this( (isAllowed) ? trueExpression : falseExpression,
              requiredDeclarations );
    }

    public MockEvalCondition(EvalExpression eval,
                             Declaration[] requiredDeclarations) {
        super( eval,
               requiredDeclarations );
    }
}