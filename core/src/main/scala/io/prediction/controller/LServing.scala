/** Copyright 2015 TappingStone, Inc.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

package io.prediction.controller

import io.prediction.core.BaseServing

/** Base class of serving. 
  *
  * @tparam Q Input query class.
  * @tparam P Output prediction class.
  * @group Serving
  */
abstract class LServing[Q, P] extends BaseServing[Q, P] {
  private[prediction]
  def serveBase(q: Q, ps: Seq[P]): P = {
    serve(q, ps)
  }

  /** Implement this method to combine multiple algorithms' predictions to
    * produce a single final prediction.
    *
    * @param query Input query.
    * @param predictions A list of algorithms' predictions.
    */
  def serve(query: Q, predictions: Seq[P]): P
}
